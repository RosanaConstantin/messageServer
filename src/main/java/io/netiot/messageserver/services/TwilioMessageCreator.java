package io.netiot.messageserver.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioMessageCreator {
    public static final String ACCOUNT_SID = "ACba8175926c740e16bafb7e4cfe69adaf";
    public static final String AUTH_TOKEN = "47340ae4b0dec3b478e559dee281ecf9";
    public static final String TWILIO_NUMBER = "+18577634697";

    public static void create(String to, String body) {
        System.out.println("create");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        System.out.println("create client");

        Message message1 = Message.creator(
                new PhoneNumber(to), // to
                new PhoneNumber(TWILIO_NUMBER), // from
                        body)
                .create();

        System.out.println(message1.getSid());
        System.out.println("everything is fine");

//        try {
//            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
//
//            // Build a filter for the MessageList
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("Body", "Hello, World!"));
//            params.add(new BasicNameValuePair("To", "+15555555555")); //Add real number here
//            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
//
//            MessageFactory messageFactory = client.getAccount().getMessageFactory();
//            Message message = messageFactory.create(params);
//            System.out.println(message.getSid());
//        }
//        catch (TwilioRestException e) {
//            System.out.println(e.getErrorMessage());
//        }
    }
}
