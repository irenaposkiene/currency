package currency;

import lt.itakademija.exam.Bank;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.CurrencyRatesProvider;
import lt.itakademija.exam.test.BaseTest;

public class Test extends BaseTest {

	@Override
	protected Bank createBank(CurrencyConverter c) {
		// TODO Auto-generated method stub
		return new MyBank (c);
	}

	@Override
	protected CurrencyConverter createCurrencyConverter(CurrencyRatesProvider p) {
		// TODO Auto-generated method stub
		return new MyCurrencyConverter(p) ;
	}

}
