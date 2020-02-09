package euler_49;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Daniel
 *
 */

public class Primes {

	private int _index;
	private int _primesArr[];

	private int _maxIntValue = 1000000000;
	private int _maxIndexValue = 50847534;
	private String _fileName = "primes.txt";

	/***************************************************************/

	public Primes() {
		init();
	}

	public Primes(int size) {
		setSize(size);
		init();
	}

	public Primes(String fileName) {
		setFileName(fileName);
		init();
	}

	public Primes(int size, String fileName) {
		setSize(size);
		setFileName(fileName);
		init();
	}

	private void init() {
		_index = 0;

		if (!ifFileExists(_fileName)) {
			_primesArr = new int[_maxIndexValue];

			primesGenarator();
			printToFile(_fileName);
		} else {
			readPrimesFromFile(_fileName);
		}
	}

	/***************************************************************/

	/**
	 * Number of primes under 10,000 - 1,229 Number of primes under 100,000 -
	 * 9,592 Number of primes under 1,000,0000 - 78,498 Number of primes under
	 * 10,000,000 - 664,579 Number of primes under 100,0000,000 - 5,761,455
	 * Number of primes under 1,000,000,000 - 50,847,534
	 */

	private void setFileName(String fileName) {
		_fileName = fileName;
	}

	private void setSize(int size) {
		_maxIntValue = size;
		setArrSize(size);
	}

	private void setArrSize(int size) {
		switch (size) {
		case 10000:
			_maxIndexValue = 1229;
			break;
		case 100000:
			_maxIndexValue = 9592;
			break;
		case 1000000:
			_maxIndexValue = 78498;
			break;
		case 10000000:
			_maxIndexValue = 664579;
			break;
		case 100000000:
			_maxIndexValue = 5761455;
			break;
		case 1000000000:
			_maxIndexValue = 50847534;
			break;

		default:
			break;
		}
	}

	private void setMaxSize() {
		switch (_maxIndexValue) {
		case 1229:
			_maxIntValue = 10000;
			break;
		case 9592:
			_maxIntValue = 100000;
			break;
		case 78498:
			_maxIntValue = 1000000;
			break;
		case 664579:
			_maxIntValue = 10000000;
			break;
		case 5761455:
			_maxIntValue = 100000000;
			break;
		case 50847534:
			_maxIntValue = 1000000000;
			break;

		default:
			break;
		}
	}

	/***************************************************************/

	private void primesGenarator() {
		_primesArr[_index++] = 2;
		_primesArr[_index++] = 3;

		for (int i = 5; i < _maxIntValue; i += 2) {
			if (isPrime(i)) {
				_primesArr[_index++] = i;
			}
		}
	}

	public boolean isPrime(int num) {
		if (_index == _maxIndexValue) {
			if (num >= _maxIntValue || num < 0)
				return false;

			return binSearch(num);
		}

		if (num % 2 == 0)
			return false;

		for (int i = 0; i < _index; i++) {
			if (_primesArr[i] <= (int) Math.sqrt(num)) {
				if (num % _primesArr[i] == 0)
					return false;
			} else
				break;
		}

		return true;
	}

	private boolean binSearch(int num) {
		int low = 0, med = 0, high = _primesArr.length - 1;
		if (num < 0)
			return false;

		while (low < high) {
			med = (high + low) / 2;

			if (num == _primesArr[med])
				return true;

			if (num < _primesArr[med]) {
				high = med - 1;
			} else {
				low = med + 1;
			}
		}

		if (num == _primesArr[low])
			return true;
		if (num == _primesArr[med])
			return true;
		if (num == _primesArr[high])
			return true;

		return false;
	}

	/***************************************************************/

	public int[] getPrimesArr() {
		return _primesArr;
	}

	public void setprimesArr(int[] _primesArr) {
		this._primesArr = _primesArr;
	}

	/***************************************************************/

	private void printToFile(String fileName) {
		FileWriter primesFileWriter = null;

		try {
			primesFileWriter = new FileWriter(fileName);
			primesFileWriter.write(_index + "\n");

			for (int i = 0; i < _index; i++) {
				primesFileWriter.write(_primesArr[i] + "\n");
			}
			primesFileWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean ifFileExists(String fileName) {
		File f = null;
		f = new File(fileName);

		if (f.exists()) {
			return true;
		}

		return false;
	}

	private void readPrimesFromFile(String fileName) {
		int readNum = 0, buff = 0;
		FileReader fileReader = null;

		try {
			fileReader = new FileReader(fileName);
			buff = fileReader.read();

			while (buff != '\n') {
				readNum *= 10;
				readNum += (buff - 48);
				buff = fileReader.read();
			}

			if (readNum < _maxIndexValue) {
				_maxIndexValue = readNum;
				setMaxSize();
			}
			_primesArr = new int[_maxIndexValue];

			while (_index < _maxIndexValue) {
				readNum = 0;

				while (buff != '\n') {
					readNum *= 10;
					readNum += (buff - 48);
					buff = fileReader.read();
				}
				_primesArr[_index++] = readNum;
				buff = fileReader.read();
			}

			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/***************************************************************/

}
