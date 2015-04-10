CREATE TRIGGER UPDATE_TIMESTAMP
  AFTER UPDATE
  ON COMMISSION 
  FOR EACH ROW
  EXECUTE PROCEDURE UPDATE_TIMESTAMP();