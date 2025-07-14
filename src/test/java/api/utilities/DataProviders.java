package api.utilities;



import org.testng.annotations.DataProvider;

public class DataProviders {

	
	public static String [][] AllDataProvider(String fileName, String sheetName){
		
        String fName = System.getProperty("user.dir")+"//TestData//"+fileName;
        
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName,sheetName);
		int ttlColCnt= ReadExcelFile.getColCount(fName, sheetName);
		
        String userData[][] = new String[ttlRowCnt-1][ttlColCnt];
		
		for(int rowNo = 1; rowNo<ttlRowCnt; rowNo++)
		{

			 
			for(int colNo=0; colNo<ttlColCnt; colNo++)
			{
				userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo);
				
			}
			
		}
		return userData;
	}
	
	@DataProvider(name = "Signindata")
	public Object[][] getLoginData() {
	    return DataProviders.AllDataProvider("Signintestdata.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "Changepassworddata")
	public Object[][] getChangepasswordDatas() {
	    return DataProviders.AllDataProvider("Changepassworddata.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "Avatardata")
	public Object[][] getAvatarData() {
	    return DataProviders.AllDataProvider("Avatartestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Avatarupdatedata")
	public Object[][] getAvatarUpdateData() {
	    return DataProviders.AllDataProvider("Avatartestupdatedata.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "Currencydata")
	public Object[][] getCurrencyDatas() {
	    return DataProviders.AllDataProvider("Currencytestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Dailyrewarddata")
	public Object[][] getDailyrewardData() {
	    return DataProviders.AllDataProvider("Dailyrewardtestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Dailyrewardupdatedata")
	public Object[][] getDailyrewardUpdateData() {
	    return DataProviders.AllDataProvider("Dailyrewardtestupdatedata.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "pointswagerdata")
	public Object[][] getPointswagerDatas() {
	    return DataProviders.AllDataProvider("Pointwagertestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "pointswagerupdatedata")
	public Object[][] getPointswagerUpdateDatas() {
	    return DataProviders.AllDataProvider("Pointwagertestupdatedata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Powerupsdata")
	public Object[][] getPowerupsData() {
	    return DataProviders.AllDataProvider("Poweruptestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Powerupsupdatedata")
	public Object[][] getPowerupsupdateData() {
	    return DataProviders.AllDataProvider("Poweruptestupdatedata.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "Spinrewarddata")
	public Object[][] getSpinrewardDatas() {
	    return DataProviders.AllDataProvider("Spinrewardtestdata.xlsx", "Sheet1");
	}
	@DataProvider(name = "Spinrewardupdatedata")
	public Object[][] getSpinrewardUpdateDatas() {
	    return DataProviders.AllDataProvider("Spinrewardtestupdatedata.xlsx", "Sheet1");
	}
	
	
	
}
