import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class AutoclosableLoggerFileHandler extends FileHandler implements AutoCloseable {
  public AutoclosableLoggerFileHandler(String pattern, boolean append) throws IOException {
    super(pattern, append);
  }

  @Override
  public void close() {
    super.close();
  }
}


public class MovieApp {
  private static final String LOG_FILE = "MovieApp.log";
  private static final Logger logger = Logger.getLogger(MovieApp.class.getName());

  private static final String STORE_NO = "100001";
  private static final String CUSTOMER_ID = "C12345678";

  public static void main(String[] args) {
    try (AutoclosableLoggerFileHandler logFileHandler =
        new AutoclosableLoggerFileHandler(LOG_FILE, false)) {
      setup_logger(logFileHandler, logger);

      try (Connection connection = getDbConnection()) {
        MovieController.controllerLoop(connection, STORE_NO, CUSTOMER_ID);
      } catch (SQLException e) {
        System.err.println("System error. Call technical support! " + e.getMessage());
        logger.log(Level.SEVERE, "Error operating on MariaDB: " + e.getMessage());
      }
    } catch (IOException e) {
      System.err.println("Error initializing log file: " + e.getMessage());
    }
  }

  private static void setup_logger(AutoclosableLoggerFileHandler fileHandler, Logger logger)
      throws IOException {
    for (Handler handler : logger.getHandlers()) {
      logger.removeHandler(handler);
    }
    logger.setUseParentHandlers(false);

    SimpleFormatter formatter = new SimpleFormatter();
    fileHandler.setFormatter(formatter);

    logger.addHandler(fileHandler);

    logger.setLevel(Level.ALL);
  }

  private static Properties loadDbProperties() {
    Properties properties = new Properties();

    try (FileInputStream fin = new FileInputStream("db.properties");) {
      properties.load(fin);
    } catch (IOException io) {
      logger.log(Level.SEVERE, "Error reading db.properties: " + io.getMessage());
    }
    return properties;
  }

  private static Connection getDbConnection() throws SQLException {
    Properties properties = loadDbProperties();
    String url = "jdbc:mariadb://" + properties.getProperty("host") + ":"
        + properties.getProperty("port") + "/" + properties.getProperty("database");
    String user = properties.getProperty("user");
    String password = properties.getProperty("password");

    Connection connection = null;
    connection = DriverManager.getConnection(url, user, password);
    logger.info("Connected to MariaDB successfully!");
    return connection;
  }
}
