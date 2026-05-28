CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price double NOT NULL,
    image_url VARCHAR(255) NOT NULL
);

INSERT INTO courses (name, description, price, image_url) VALUES
('Java BootCamp 2024', 'Lộ trình từ Zero đến Hero với Spring Boot và Microservices', 499.0, '/uploads/java-hero.png'),
('Python cho Data Science', 'Pandas, NumPy, Matplotlib, cơ bản đến chuyên sâu', 299.0, '/uploads/python-ds-xyz123.png'),
('ReactJS & Next.js Master', 'Xây dựng ứng dụng Web hiện đại với Performance tối ưu', 350.0, '/uploads/react-next.png'),
('Database Design', 'Tối ưu hóa truy vấn và thiết kế DB chuẩn hóa', 199.0, '/uploads/db-design.png'),
('DevOps Essentials', 'Docker, Kubernetes và CI/CD cơ bản', 550.0, '/uploads/devops-basic.png');