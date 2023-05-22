package ru.irenademchenkova.dao_layer.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.irenademchenkova.dao_layer.entities.CustomerMapper;
import ru.irenademchenkova.dao_layer.entities.OrderMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
public class Repository implements RepositoryInterface {
    private final String scriptFileName = "script.sql";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;

    public Repository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                      CustomerMapper customerMapper, OrderMapper orderMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.customerMapper = customerMapper;
        this.orderMapper = orderMapper;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getProductName(String name) {
        var params = new MapSqlParameterSource();
        params.addValue("name", name);
        namedParameterJdbcTemplate.query(
                        Repository.read(scriptFileName),
                        params,
                        customerMapper
                ).stream()
                .forEach(System.out::println);
        return "";
    }
}
