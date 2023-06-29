CREATE DATABASE IF NOT EXISTS flightbooking;
USE flightbooking;
CREATE TABLE  IF NOT EXISTS admin_credentials(id int not null auto_increment,username varchar(25),password varchar(25),email_id varchar(30),CONSTRAINT admin_pk PRIMARY KEY(id))ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

INSERT INTO `admin_credentials`(username,password,email_id)VALUES("admin","admin","flaviandiold@gmail.com");

CREATE TABLE IF NOT EXISTS `user_details` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(50) NOT NULL,
  `u_gender` varchar(10) NOT NULL,
  `u_address` varchar(100) NOT NULL,
  `u_email_id` varchar(50) NOT NULL,
  `u_contact` varchar(10) NOT NULL,
  `u_username` varchar(30) NOT NULL,
  `u_password` varchar(30) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `flight_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flightno` varchar(10) NOT NULL,
  `from_city` varchar(20) NOT NULL,
  `to_city` varchar(20) NOT NULL,
  `departure_date` varchar(20) NOT NULL,
  `arrival_date` varchar(20) NOT NULL,
  `departure_time` varchar(20) NOT NULL,
  `arrival_time` varchar(20) NOT NULL,
  `e_seats_left` int(3) NOT NULL DEFAULT '45',
  `b_seats_left` int(3) NOT NULL DEFAULT '15',
  `e_price` int(5) NOT NULL,
  `b_price` int(5) NOT NULL,
  `flight_company` VARCHAR(40) NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `passenger_details` (
  `p_id` int(11) NOT NULL,
  `p_pnr` varchar(25) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_age` varchar(3) NOT NULL,
  `p_sex` varchar(10) NOT NULL,
  `p_fno` varchar(10) NOT NULL,
  `p_from` varchar(10) NOT NULL,
  `p_to` varchar(10) NOT NULL,
  `p_dedate` date DEFAULT NULL,
  `p_ardate` date DEFAULT NULL,
  `p_detime` varchar(20) NOT NULL,
  `p_artime` varchar(20) NOT NULL,
  `p_status` varchar(20) NOT NULL,
  `p_class` varchar(10) NOT NULL,
  `p_seatno` int(20) NOT NULL,
  `p_email` varchar(30) DEFAULT NULL,
  `p_bookingdate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `passenger_details`
  ADD PRIMARY KEY (`p_id`);

ALTER TABLE `passenger_details`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

CREATE TABLE PNR(PNR_NO VARCHAR(20),TOTAL_AMOUNT DOUBLE);