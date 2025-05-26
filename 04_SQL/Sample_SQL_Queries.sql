-- Найти всех активных клиентов
SELECT * FROM clients WHERE status = 'active';

-- Посчитать количество заказов в мае
SELECT COUNT(*) FROM orders WHERE order_date BETWEEN '2024-05-01' AND '2024-05-31';

-- Найти клиентов без заказов
SELECT name FROM clients WHERE id NOT IN (SELECT client_id FROM orders);
