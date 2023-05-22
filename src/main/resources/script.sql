select customers.name, orders.product_name
from customers
join orders on customers.id = orders.customer_id
where name =:name;