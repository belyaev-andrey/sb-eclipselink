-- Insert test todo items specifically for TodoControllerTest
-- Reset the sequence to ensure IDs start from 1
ALTER SEQUENCE todos_id_seq RESTART WITH 1;

-- Insert todos with specific IDs for tests
INSERT INTO todos (title, description, completed, created_at) 
VALUES 
    ('Task 1', 'Description 1', false, NOW()),
    ('Task 2', 'Description 2', false, NOW());