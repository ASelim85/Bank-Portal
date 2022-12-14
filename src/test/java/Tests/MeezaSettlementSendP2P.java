package Tests;

import APIS.CashOut;
import APIS.Deposit;
import APIS.P2P;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

public class MeezaSettlementSendP2P extends TestBase {

    P2P p2p = new P2P();
    CashOut cashout = new CashOut();
    Deposit deposit = new Deposit();

    @Test(priority = 0, enabled = true)
    public void Send_P2P_OffUs() throws IOException, ParseException {
       loginTestCases.LoginWithValidCredentials();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //Get VOLUMES Numbers
        //Transactions
        String finalTransactionsVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTransaction().add(new BigDecimal(1)));
        System.out.println("Transactions: " + finalTransactionsVolumeBeforeTrx);

        //Interchange Debit
        String finalInterchangeDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("Interchange Debit: " + finalInterchangeDebitVolumeBeforeTrx);

        //Total Debit
        String finalTotalDebitVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit().add(new BigDecimal(1)));
        System.out.println("Total Debit: " + finalTotalDebitVolumeBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeBeforeTrx: " + finalInterchangeCreditVolumeBeforeTrx);

        //Total Credit
        String finalTotalCreditVolumeBeforeTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeBeforeTrx: " + finalTotalCreditVolumeBeforeTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String finalTransactionsValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueBeforeTrx: " + finalTransactionsValueBeforeTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueBeforeTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit().add(new BigDecimal(1)));
        System.out.println("finalInterchangeDebitValueBeforeTrx: " + finalInterchangeDebitValueBeforeTrx);

        //Total Debit
        String finalTotalDebitValueBeforeTrx = String.valueOf(meezaReportPage.value_getTotalDebit().add(new BigDecimal(11)));
        System.out.println("finalTotalDebitValueBeforeTrx: " + finalTotalDebitValueBeforeTrx);

        //Interchange Credit
        String finalInterchangeCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditBeforeTrx: " + finalInterchangeCreditBeforeTrx);

        //Total Credit
        String finalTotalCreditBeforeTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditBeforeTrx: " + finalTotalCreditBeforeTrx);

        //Processing Fees
        double finalProcessingFeesBeforeTrx = meezaReportPage.value_GetProcessingFees().add(new BigDecimal(1)).doubleValue();
        System.out.println("finalProcessingFeesBeforeTrx: " + finalProcessingFeesBeforeTrx);

        //Net Position
        String finalNetPositionBeforeTrx = String.valueOf(meezaReportPage.value_GetNetPosition().subtract(new BigDecimal(11)));
        System.out.println("finalNetPositionBeforeTrx: " + finalNetPositionBeforeTrx);

        p2p.Send_P2P_OffUs();
        p2p.Send_P2P_OffUs_Advice();
        refresh();

        //Get VOLUMES After execute P2P transaction
        //Transactions
        String finalTransactionsVolumeAfterTrx= String.valueOf(meezaReportPage.volume_GetTransaction());
        System.out.println("finalTransactionsVolumeAfterTrx "+finalTransactionsVolumeAfterTrx);

        //InterChagedebit
        String finalInterchangeDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitVolumeAfterTrx "+finalInterchangeDebitVolumeAfterTrx);

        //Total Debit
        String finalTotalDebitVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalDebit());
        System.out.println("finalTotalDebitVolumeAfterTrx "+finalTotalDebitVolumeAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditVolumeAfterTrx: " + finalInterchangeCreditVolumeAfterTrx);

        //Total Credit
        String finalTotalCreditVolumeAfterTrx = String.valueOf(meezaReportPage.volume_GetTotalCredit());
        System.out.println("finalTotalCreditVolumeAfterTrx: " + finalTotalCreditVolumeAfterTrx);

        Assert.assertEquals(finalTransactionsVolumeAfterTrx,finalTransactionsVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitVolumeAfterTrx,finalInterchangeDebitVolumeBeforeTrx);
        Assert.assertEquals(finalTotalDebitVolumeAfterTrx,finalTotalDebitVolumeBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditVolumeAfterTrx,finalInterchangeCreditVolumeBeforeTrx);
        Assert.assertEquals(finalTotalCreditVolumeAfterTrx,finalTotalCreditVolumeBeforeTrx);


        //Click Values
        meezaReportPage.clickValues();

        //Values After execute P2P transaction
        //Transactions
        String finalTransactionsValueAfterTrx = String.valueOf(meezaReportPage.Value_GetTransactionValue());
        System.out.println("finalTransactionsValueAfterTrx: " + finalTransactionsValueAfterTrx);

        //InterChange Debit Value
        String finalInterchangeDebitValueAfterTrx = String.valueOf(meezaReportPage.Value_GetInterchangeDebit());
        System.out.println("finalInterchangeDebitValueAfterTrx: " + finalInterchangeDebitValueAfterTrx);

        //Total Debit
        String finalTotalDebitValueAfterTrx = String.valueOf(meezaReportPage.value_getTotalDebit());
        System.out.println("finalTotalDebitValueAfterTrx: " + finalTotalDebitValueAfterTrx);

        //Interchange Credit
        String finalInterchangeCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetInterchangeCredit());
        System.out.println("finalInterchangeCreditValueAfterTrx: " + finalInterchangeCreditValueAfterTrx);

        //Total Credit
        String finalTotalCreditValueAfterTrx = String.valueOf(meezaReportPage.value_GetTotalCredit());
        System.out.println("finalTotalCreditValueAfterTrx: " + finalTotalCreditValueAfterTrx);

        //Processing Fees
        double finalProcessingFeesValueAfterTrx = meezaReportPage.value_GetProcessingFees().doubleValue();
        System.out.println("finalProcessingFeesValueAfterTrx: " + finalProcessingFeesValueAfterTrx);

        //Net Position
        String finalNetPositionValueAfterTrx = String.valueOf(meezaReportPage.value_GetNetPosition());
        System.out.println("finalNetPositionValueAfterTrx: " + finalNetPositionValueAfterTrx);


        Assert.assertEquals(finalTransactionsValueAfterTrx,finalTransactionsValueBeforeTrx);
        Assert.assertEquals(finalInterchangeDebitValueAfterTrx,finalInterchangeDebitValueBeforeTrx);
        Assert.assertEquals(finalTotalDebitValueAfterTrx,finalTotalDebitValueBeforeTrx);
        Assert.assertEquals(finalInterchangeCreditValueAfterTrx,finalInterchangeCreditBeforeTrx);
        Assert.assertEquals(finalTotalCreditValueAfterTrx,finalTotalCreditBeforeTrx);
        Assert.assertEquals(finalProcessingFeesValueAfterTrx,finalProcessingFeesBeforeTrx);
        Assert.assertEquals(finalNetPositionValueAfterTrx,finalNetPositionBeforeTrx);

    }

}
