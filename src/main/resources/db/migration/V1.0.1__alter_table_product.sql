ALTER TABLE t_product ADD active BOOLEAN;
UPDATE t_product
SET
    active = true
WHERE
    active is null;