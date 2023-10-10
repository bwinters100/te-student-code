package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    private static final double Uno = 1.0;
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_with_valid_id_returns_correct_timesheet() {
        Timesheet timesheetOne = dao.getTimesheetById(1);
        assertTimesheetsMatch(timesheetOne, TIMESHEET_1 );
        Timesheet timesheetTwo = dao.getTimesheetById(2);
        assertTimesheetsMatch(timesheetTwo, TIMESHEET_2 );
        Timesheet timesheetThree = dao.getTimesheetById(3);
        assertTimesheetsMatch(timesheetThree, TIMESHEET_3 );
        Timesheet timesheetFour = dao.getTimesheetById(4);
        assertTimesheetsMatch(timesheetFour, TIMESHEET_4 );

    }

    @Test
    public void getTimesheetById_with_invalid_id_returns_null_timesheet() {
        Assert.assertEquals(null, dao.getTimesheetById(5) );
    }

    @Test
    public void getTimesheetsByEmployeeId_with_valid_employee_id_returns_list_of_timesheets_for_employee() {
        List<Timesheet> timeSheets = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2, timeSheets.size());
        List<Timesheet> timeSheetsTwo = dao.getTimesheetsByEmployeeId(2);
        Assert.assertEquals(2, timeSheetsTwo.size());
    }

    @Test
    public void getTimesheetsByProjectId_with_valid_id_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3, timesheets.size());
        List<Timesheet> timesheetsTwo = dao.getTimesheetsByProjectId(2);
        Assert.assertEquals(1, timesheetsTwo.size());
        Assert.assertNotNull(timesheets);
    }

    @Test
    public void createTimesheet_creates_timesheet() {
        Timesheet timesheet = dao.createTimesheet(TIMESHEET_1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet );
        Timesheet timesheet2 = dao.createTimesheet(TIMESHEET_2);
        assertTimesheetsMatch(TIMESHEET_2, timesheet2 );
        Timesheet timesheet3 = dao.createTimesheet(TIMESHEET_3);
        assertTimesheetsMatch(TIMESHEET_3, timesheet3 );
        Timesheet timesheet4 = dao.createTimesheet(TIMESHEET_4);
        assertTimesheetsMatch(TIMESHEET_4, timesheet4 );
    }

    @Test
    public void updateTimesheet_updates_timesheet() {
        Timesheet TimesheetToUpdate = dao.getTimesheetById(1);
        TimesheetToUpdate.setHoursWorked(2.0);
        Timesheet updatedTimesheet = dao.updateTimesheet(TimesheetToUpdate);
        Timesheet retrieveTimesheet = dao.getTimesheetById(1);
        Assert.assertEquals(0,Double.compare(updatedTimesheet.getHoursWorked(), retrieveTimesheet.getHoursWorked()));


    }

    @Test
    public void deleteTimesheetById_deletes_timesheet() {
        int rowsAffected = dao.deleteTimesheetById(1);
        Assert.assertEquals(1, rowsAffected);
        Timesheet timesheet = dao.getTimesheetById(1);
        Assert.assertNull(timesheet);
        int rowsAffected2 = dao.deleteTimesheetById(2);
        Assert.assertEquals(1, rowsAffected2);
        Timesheet timesheet2 = dao.getTimesheetById(2);
        Assert.assertNull(timesheet2);
        int rowsAffected3 = dao.deleteTimesheetById(3);
        Assert.assertEquals(1, rowsAffected3);
        Timesheet timesheet3 = dao.getTimesheetById(3);
        Assert.assertNull(timesheet3);
        int rowsAffected4 = dao.deleteTimesheetById(4);
        Assert.assertEquals(1, rowsAffected4);
        Timesheet timesheet4 = dao.getTimesheetById(4);
        Assert.assertNull(timesheet4);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double actualHours = dao.getBillableHours(1, 1);
        Assert.assertEquals(0,Double.compare(2.50, actualHours));
        double actualHours2 = dao.getBillableHours(2, 2);
        Assert.assertEquals(0,Double.compare(2.0, actualHours2));

    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
