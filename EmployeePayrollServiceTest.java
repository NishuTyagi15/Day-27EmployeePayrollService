package com.employeepayroll;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.employeepayroll.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Nishu", 500000.0),
				new EmployeePayrollData(2, "Krati", 550000.0), new EmployeePayrollData(3, "Pravigya", 600000.0) };

		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
	}
}
