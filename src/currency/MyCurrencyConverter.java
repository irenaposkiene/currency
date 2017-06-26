package currency;

import lt.itakademija.exam.Currency;
import lt.itakademija.exam.CurrencyConversionException;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.CurrencyRatesProvider;
import lt.itakademija.exam.Money;

public class MyCurrencyConverter implements CurrencyConverter {

	CurrencyRatesProvider pro;
	
	public MyCurrencyConverter(CurrencyRatesProvider p) {
		// TODO Auto-generated constructor stub
		this.pro=p;
	}

	@Override
	public Money convert(Currency c1, Currency c2, Money m) {
		if (pro.getRate(c1, c2)== null){
			throw new CurrencyConversionException("ERROR");
		}
		// TODO Auto-generated method stub
		return m.multiply(pro.getRate(c1, c2));
	}

}
