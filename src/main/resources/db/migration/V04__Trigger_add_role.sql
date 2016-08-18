DELIMITER $$
CREATE TRIGGER Tgr_add_role AFTER INSERT
ON user
FOR EACH ROW
BEGIN 
	INSERT INTO user_roles (user_id, role) VALUES (NEW.id_user, 'USER');  
END$$
DELIMITER ;
