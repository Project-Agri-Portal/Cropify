

-- ---------------------------------- admin table--------------------------------------------

INSERT INTO admin (admin_mobile, admin_email, first_name, root_admin, join_date, last_name, admin_password) VALUES
('1234567890', 'admin1@example.com', 'Aarav', 1, '2022-01-01', 'Patel', 'password123'),
('9876543210', 'admin2@example.com', 'Aditi', 0, '2022-01-02', 'Sharma', 'admin@2022'),
('5556667777', 'admin3@example.com', 'Aryan', 0, '2022-01-03', 'Verma', 'securePassword'),
('9998887777', 'admin4@example.com', 'Avani', 0, '2022-01-04', 'Joshi', 'myAdminPass'),
('7778889999', 'admin5@example.com', 'Dev', 1, '2022-01-05', 'Singh', 'passWord2022'),
('4445556666', 'admin6@example.com', 'Esha', 0, '2022-01-06', 'Kumar', 'secretPass'),
('2223334444', 'admin7@example.com', 'Kabir', 0, '2022-01-07', 'Mishra', 'admin123'),
('6665554444', 'admin8@example.com', 'Ishika', 0, '2022-01-08', 'Gupta', '1234Secure'),
('1112223333', 'admin9@example.com', 'Mihir', 0, '2022-01-09', 'Pandey', 'p@ssw0rd'),
('8887776666', 'admin10@example.com', 'Riya', 1, '2022-01-10', 'Malhotra', 'dummyAdminPass');

-------------------------------- agriculture_products table ------------------------------------

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path) VALUES
('AP001', 'NeemGuard', 'Insecticide', '/images/neemguard.jpg'),
('AP002', 'BioShield', 'Biopesticide', '/images/bioshield.jpg'),
('AP003', 'GreenShield', 'Herbicide', '/images/greenshield.jpg'),
('AP004', 'CropVital', 'Fungicide', '/images/cropvital.jpg'),
('AP005', 'TurmericGuard', 'Insecticide', '/images/turmericguard.jpg'),
('AP006', 'OrganicShield', 'Biopesticide', '/images/organicshield.jpg'),
('AP007', 'LeafSafe', 'Herbicide', '/images/leafsafe.jpg'),
('AP008', 'MintFresh', 'Fungicide', '/images/mintfresh.jpg'),
('AP009', 'RiceProtector', 'Insecticide', '/images/riceprotector.jpg'),
('AP010', 'FruitDefender', 'Biopesticide', '/images/fruitdefender.jpg');

--------------------------------- farm_products table -----------------------------

INSERT INTO farm_products (farm_prod_id, farm_prod_name, farm_prod_type, img_path) VALUES
('FP001', 'Basmati Rice', 'Grains', '/images/basmati_rice.jpg'),
('FP002', 'Alphonso Mangoes', 'Fruits', '/images/alphonso_mangoes.jpg'),
('FP003', 'Masoor Dal', 'Pulses', '/images/masoor_dal.jpg'),
('FP004', 'Turmeric Powder', 'Spices', '/images/turmeric_powder.jpg'),
('FP005', 'Desi Ghee', 'Dairy', '/images/desi_ghee.jpg'),
('FP006', 'Kesar', 'Herbs', '/images/kesar.jpg'),
('FP007', 'Darjeeling Tea', 'Beverages', '/images/darjeeling_tea.jpg'),
('FP008', 'Papaya', 'Fruits', '/images/papaya.jpg'),
('FP009', 'Mustard Oil', 'Edible Oils', '/images/mustard_oil.jpg'),
('FP010', 'Jaggery', 'Sweeteners', '/images/jaggery.jpg');

--------------------------------- machinery table -----------------------------------

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type) VALUES
('M001', '/images/tractor.jpg', 'Kisan King Tractor', 'TRACTOR'),
('M002', '/images/plough.jpg', 'Harit Kranti Plough', 'PLOUGH'),
('M003', '/images/harvester.jpg', 'Krishi Sampada Harvester', 'HARVESTOR'),
('M004', '/images/seeder.jpg', 'Beej Boy Seeder', 'SEEDER'),
('M005', '/images/irrigation_pump.jpg', 'Jal Shakti Pump', 'IRRIGATION_PUMP'),
('M006', '/images/crop_sprayer.jpg', 'Swasthya Khet Crop Sprayer', 'CROP_SPRAYER'),
('M007', '/images/tiller.jpg', 'Krishi Sathi Tiller', 'TILLER'),
('M008', '/images/thresher.jpg', 'Annapurna Thresher', 'THRESHER'),
('M009', '/images/cultivator.jpg', 'Utkarsh Krishi Cultivator', 'CULTIVATOR'),
('M010', '/images/seed_drill.jpg', 'Beej Express Seed Drill', 'SEED_DRILL');


---------------------------------------- user_details table -----------------------------------

INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type) VALUES
('112233445566', 'amit.verma@example.com', 'Amit', 'Verma', '9876543211', 'ABCD123456', 'hashed_password', 'Active', 'Jaipur', '456, XYZ Street, ABC Colony', '302001', 'Rajasthan', 'FARMER'),
('223344556677', 'poonam.gupta@example.com', 'Poonam', 'Gupta', '8765432101', 'PQRS567890', 'hashed_password', 'Active', 'Lucknow', '789, LMN Street, PQR Colony', '226001', 'Uttar Pradesh', 'SELLER'),
('334455667788', 'mohan.sharma@example.com', 'Mohan', 'Sharma', '7654321090', 'WXYZ123456', 'hashed_password', 'Active', 'Hyderabad', '101, UVW Street, LMN Colony', '500001', 'Telangana', 'CUSTOMER'),
('445566778899', 'neha.yadav@example.com', 'Neha', 'Yadav', '6543210981', 'LMNO567890', 'hashed_password', 'Inactive', 'Ahmedabad', '202, PQR Street, WXY Colony', '380001', 'Gujarat', 'FARMER'),
('556677889900', 'raj.mishra@example.com', 'Raj', 'Mishra', '5432109872', 'UVWX123456', 'hashed_password', 'Active', 'Chandigarh', '303, ABC Street, XYZ Colony', '160001', 'Punjab', 'SELLER'),
('667788990011', 'ananya.singh@example.com', 'Ananya', 'Singh', '4321098765', 'PQRS123456', 'hashed_password', 'Active', 'Bhopal', '505, WXY Street, UVW Colony', '462001', 'Madhya Pradesh', 'SELLER');
