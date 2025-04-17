-- Insert sample todo items
INSERT INTO todos (title, description, completed, created_at) 
VALUES 
    ('Complete project documentation', 'Write comprehensive documentation for the project including API endpoints and database schema', false, NOW()),
    ('Implement user authentication', 'Add user authentication using JWT tokens', false, NOW()),
    ('Fix navigation bug', 'Fix the navigation bug in the header that appears on mobile devices', false, NOW()),
    ('Optimize database queries', 'Review and optimize slow database queries to improve performance', false, NOW()),
    ('Deploy to production', 'Deploy the latest version to production environment', false, NOW()),
    ('Write unit tests', 'Increase test coverage by writing more unit tests', true, NOW() - INTERVAL '2 days'),
    ('Code review', 'Complete code review for pull request #42', true, NOW() - INTERVAL '1 day'),
    ('Update dependencies', 'Update all project dependencies to their latest versions', true, NOW() - INTERVAL '3 days'),
    ('Create database backup script', 'Write a script to automate database backups', false, NOW()),
    ('Refactor error handling', 'Implement consistent error handling across the application', false, NOW());