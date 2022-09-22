package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataP {
	@DataProvider(name="dp")
	public Object[][] provideCridentials() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/OpportunityExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Object [][] a=new Object[3][2];
		for(int i=0;i<3;i++) {
		for(int j=0;j<2;j++) {
		a[i][j]=wb.getSheet("Sheet2").getRow(i).getCell(j).toString();
		}}
		Arrays.sort(a,new Comparator<Object[]>() {

			public int compare(Object[] o1, Object[] o2) {
				
				return o1[0].toString().compareTo(o2[0].toString());
			}
		});
		return a;
	}

}
