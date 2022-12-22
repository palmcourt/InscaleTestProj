package Test;

import Pages.AddCustomerPage;
import Pages.CustomerListPage;
import Pages.LoginPage;
import Pages.ManagerPage;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 extends BaseClass {

    @Test
    public void test_one() throws Throwable {

        MultiValuedMap<String, Map<String, String>> map = new ArrayListValuedHashMap<>();
        MultiValuedMap<String, Map<String, String>> deleteCustomers = new ArrayListValuedHashMap<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("Christopher", "Connely");

        Map<String, String> map2 = new HashMap<>();
        map2.put("Frank", "Christopher");

        Map<String, String> map3 = new HashMap<>();
        map3.put("Christopher", "Minka");

        Map<String, String> map4 = new HashMap<>();
        map4.put("Connely", "Jackson");

        Map<String, String> map5 = new HashMap<>();
        map5.put("Jackson", "Frank");

        Map<String, String> map6 = new HashMap<>();
        map6.put("Minka", "Jackson");

        Map<String, String> map7 = new HashMap<>();
        map7.put("Jackson", "Connely");

        Map<String, String> map8 = new HashMap<>();
        map8.put("Lawrence", "Zimmerman");

        Map<String, String> map9 = new HashMap<>();
        map9.put("Mariotte", "Tova");

        map.put("L789C349", map1);
        map.put("A897N450", map2);
        map.put("M098Q585", map3);
        map.put("L789C349", map4);
        map.put("L789C349", map5);
        map.put("A897N450", map6);
        map.put("L789C349", map7);
        map.put("L789C349", map8);
        map.put("L789C349", map9);

        deleteCustomers.put("L789C349", map5);
        deleteCustomers.put("L789C349", map1);

        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        List<String> postCodes = new ArrayList<>();

        for (Map.Entry<String, Map<String, String>> entry : map.entries()) {

            LoginPage login = new LoginPage();
            login.clickLogin("Manager", driver);
            ManagerPage managerPage = new ManagerPage();
            managerPage.clickAddCustomer(driver);
            AddCustomerPage addCustomer = new AddCustomerPage();
            addCustomer.addCustomer(driver, entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim(),
                    entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim(),
                    entry.getKey());

            System.out.println("Customer added" +
                    "\n   FName :" + entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim() +
                    " LName :" + entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim() +
                    " PostCode : " + entry.getKey());

            firstNames.add(entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim());
            lastNames.add(entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim());
            postCodes.add(entry.getKey());


        }

        LoginPage login = new LoginPage();
        login.clickLogin("Manager", driver);
        AddCustomerPage addCustomer = new AddCustomerPage();
        addCustomer.clickOnCustomer(driver);
        CustomerListPage customerPage = new CustomerListPage();
        customerPage.verifyAddedCustomers(driver, firstNames);

        for (Map.Entry<String, Map<String, String>> entry : deleteCustomers.entries()) {

            customerPage.searchByCustomer(driver, entry.getKey());
            customerPage.deleteCustomer(driver,
                    entry.getValue().keySet().toString().replace("[", " ").replace("]", " ").trim(),
                    entry.getValue().values().toString().replace("[", " ").replace("]", " ").trim(),
                    entry.getKey());
        }
        customerPage.clickHomeButton(driver);
    }


    /*@DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {
        return new Object[][]{
                {"Christopher", "Connely", "L789C349"},
                {"Frank", "Christopher", "A897N450"},
                {"Christopher", "Minka", "M098Q585"},
                {"Connely", "Jackson", "L789C349"},
                {"Jackson", "Frank", "L789C349"},
                {"Minka", "Jackson", "A897N450"},
                {"Jackson", "Connely", "L789C349"},
                {"Lawrence", "Zimmerman", "L789C349"},
                {"Mariotte", "Tova", "L789C349"},
        };
    }*/
}
