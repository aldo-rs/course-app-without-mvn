package com.codetodo.courseapp.web;

import com.codetodo.courseapp.dao.H2ConnectionFactory;
import org.h2.tools.RunScript;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class CourseDBInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        final Connection h2Connection = getConnection();

        execSchemaCreationScripts(h2Connection);
        populateH2DataBase(h2Connection);
    }

    private Connection getConnection() {
        final H2ConnectionFactory connectionFactory = new H2ConnectionFactory();
        return connectionFactory.getConnection();
    }

    private void execSchemaCreationScripts(final Connection con) {
        System.out.println("Executing schema creation scripts");
        execScript(con, "/db/schema-h2.sql");
    }

    private void populateH2DataBase(final Connection con) {
        System.out.println("Populating H2 data base");
        execScript(con, "/db/data-h2.sql");
    }

    private void execScript(final Connection con, final String scriptName) {
        final InputStream is = this.getClass().getResourceAsStream(scriptName);
        final Reader reader = new InputStreamReader(is);

        try {
            RunScript.execute(con, reader);
        } catch (SQLException sqlException) {
            System.out.println("Failed to execute " + scriptName + " script");
        }
    }

}
