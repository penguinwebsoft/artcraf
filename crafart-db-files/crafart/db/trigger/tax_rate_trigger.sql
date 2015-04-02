CREATE TRIGGER UPDATE_TIMESTAMP
  AFTER UPDATE
  ON TAX_RATE 
  FOR EACH ROW
  EXECUTE PROCEDURE UPDATE_TIMESTAMP();