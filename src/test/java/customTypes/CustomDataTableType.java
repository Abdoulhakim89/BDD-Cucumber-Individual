package customTypes;

import domainObjects.BillingDetailsObject;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {
    @DataTableType
    public BillingDetailsObject billingDetailsEntry(Map<String, String> entries){
        return new BillingDetailsObject(
                entries.get("firstname"),
                entries.get("lastname"),
                entries.get("country"),
                entries.get("street_address"),
                entries.get("town"),
                entries.get("state"),
                entries.get("zip"),
                entries.get("email")
        );

    }
}
