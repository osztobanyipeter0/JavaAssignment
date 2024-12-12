CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE properties (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    is_prepared BOOLEAN NOT NULL,
    rooms INT,
    windows INT,
    radiators INT,
    lights INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE features (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    base_cost DECIMAL(10, 2),
    description TEXT
);

CREATE TABLE selected_features (
    id UUID PRIMARY KEY,
    property_id UUID REFERENCES properties(id),
    feature_id UUID REFERENCES features(id),
    quantity INT
);

CREATE TABLE estimates (
    id UUID PRIMARY KEY,
    property_id UUID REFERENCES properties(id),
    user_id UUID REFERENCES users(id),
    total_cost DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
