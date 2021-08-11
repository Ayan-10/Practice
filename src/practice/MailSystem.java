package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MailSystem {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int totalMails = Integer.parseInt(in.nextLine());

        String[] mailIds = new String [totalMails];
        for(int j = 0; j < mailIds.length;j++)
        {
            mailIds[j] = in.nextLine();
        }

        String[] sortedMailIds = sortMailIds(mailIds);
        sendEmail(sortedMailIds,"Hi");
    }

    private static String[] sortMailIds(String[] mailIds) {
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i< mailIds.length; i++){
            int index = mailIds[i].indexOf('@');
            String domain = mailIds[i].substring(index+1);
            map.put(domain, mailIds[i]);
            mailIds[i]=domain;
        }

        Arrays.sort(mailIds);
        String[] sortedMailIds = new String[mailIds.length];
        for(int i = 0; i< mailIds.length; i++){
            String domain = mailIds[i];
            String mailId = map.get(domain);
            sortedMailIds[i] = mailId;
        }

        return sortedMailIds;
    }

    public static void sendEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
