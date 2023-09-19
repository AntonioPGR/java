package currency_converter.currency;

import currency_converter.Exception.APIException;
import currency_converter.api.CurrencyAPIFormat;
import currency_converter.api.CurrencyApiHandler;
import currency_converter.api.JsonConverter;

import java.net.http.HttpResponse;

public class Currency {
	String from;
	String to;
	CurrencyApiHandler converter = new CurrencyApiHandler();

	public Currency(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public void convert(float amount) throws APIException {
		String httpResponse = converter.convertAmountFromTo(amount, from, to);
		if(httpResponse == null){
			throw new APIException("Unable to reach the API");
		}
		CurrencyAPIFormat data = JsonConverter.getObjectFromJson(httpResponse, CurrencyAPIFormat.class);
		if(data.error() > 0){
			throw new APIException(data.error_message());
		}
	}

}
