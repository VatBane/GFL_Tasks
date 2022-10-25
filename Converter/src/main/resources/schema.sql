DROP TABLE IF EXISTS convertation;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title varchar(128),
    count INTEGER DEFAULT 0,
    UNIQUE(title)
);

CREATE TABLE convertation (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    from_quantity varchar(32),
    to_quantity varchar(32),
    multiplier DECIMAL,
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES category,
    UNIQUE(from_quantity, to_quantity)
);

CREATE OR REPLACE FUNCTION calculate_count() RETURNS TRIGGER AS '
BEGIN
UPDATE category SET count = (SELECT COUNT(*) FROM convertation where category_id = category.id);
RETURN NEW;
END;
' LANGUAGE plpgsql;

CREATE TRIGGER update_count AFTER INSERT OR DELETE ON convertation
    FOR EACH ROW EXECUTE PROCEDURE calculate_count()
