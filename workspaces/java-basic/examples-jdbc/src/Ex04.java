import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Ex04 {

	public static void main(String[] args) {
		
		readLottoNumbersFromCsv("lotto-winning-numbers-by-round.csv");

	}

	private static void readLottoNumbersFromCsv(String csvPath) {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		FileReader fr = null;
		CSVReader csvr = null;
		try {
			//fis = new FileInputStream(csvPath); // 파일에서 byte[] 형식으로 데이터 읽기 도구
			//isr = new InputStreamReader(fis);	// byte[] -> char[] 변경하는 도구
			fr = new FileReader(csvPath);
			//csvr = new CSVReader(isr);
			csvr = new CSVReader(fr);
			while (true) {
				String[] row = csvr.readNext();	// 파일에서 한 행의 데이터를 읽기
				if (row == null) { // EOF (end of file)
					break;
				}
				System.out.printf("[%s][%s][%s][%s][%d]\n", row[0], row[1], row[2], row[3], row.length);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} catch (IOException ex) {
			ex.printStackTrace();	// 오류 메시지 표시
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} finally {
			try { csvr.close(); } catch (Exception ex) {}
			try { isr.close(); } catch (Exception ex) {}
			try { fis.close(); } catch (Exception ex) {}
		}
	}

}
