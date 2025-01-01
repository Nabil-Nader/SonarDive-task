-- Create Country Table
CREATE TABLE Country (
    id INT PRIMARY KEY AUTO_INCREMENT,
    iso_Code VARCHAR(10) NOT NULL
);

-- Create Company Table
CREATE TABLE Company (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country_id INT NOT NULL,
    CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES Country(id)
);

-- Insert data into Country Table
INSERT INTO Country (id, iso_Code) VALUES (1, 'US'), (2, 'IN');

-- Insert data into Company Table
INSERT INTO Company (id, name, country_id) VALUES (1, 'Google', 1), (2, 'Infosys', 2);
