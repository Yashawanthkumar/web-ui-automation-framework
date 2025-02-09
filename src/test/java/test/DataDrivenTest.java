package test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.DBUtils;
import utils.ReadExternalDataUtil;

public class DataDrivenTest extends BaseTest {
    
    @DataProvider(name = "ExcelData")
    public Object[][] getExcelData() {
        return ReadExternalDataUtil.getExcelData();
    }
    
    @Test(dataProvider = "ExcelData")
    public void testWithExcelData(String username, String password) {
        System.out.println("Testing with Excel data: " + username + " - " + password);
        Assert.assertNotNull(username);
    }
    
    @DataProvider(name = "JsonData")
    public Object[][] getJsonData() {
        return ReadExternalDataUtil.getJsonData();
    }
    
    @Test(dataProvider = "JsonData")
    public void testWithJsonData(String username, String password) {
        System.out.println("Testing with JSON data: " + username + " - " + password);
        Assert.assertNotNull(password);
    }
    
    @Test
    public void testWithDBData() {
        String query = "SELECT username, password FROM users WHERE active=1 LIMIT 1";
        Map<String, Object> userData = DBUtils.getSingleRowData(query);
        System.out.println("Testing with DB data: " + userData.get("name") + " - " + userData.get("password"));
        Assert.assertNotNull(userData.get("name"));
    }
}