package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import play.mvc.Controller;
import play.mvc.Result;
/**
 * @author valore
 *
 */
public class Application extends Controller {

	public static Result index() {
		return ok();
	}
	
	public static Result protectPdf() {
		
		
		try {
		    String k = "<html><body><table cellspacing='0' cellpadding='0' width='100%'><tr><td style='border: 1px solid black;' align='center'><span>&nbsp;Aurum Info Solutions</span><br /><span>&nbsp;Payslip for the month of </span>January 2016</span><br /><span>&nbsp;Financial Period </span>2015 - 2016</span></td></tr><tr style='text-align:right;'><td colspan='2' style='border: 1px solid black; border-top: 0;'><span><strong>Private &amp; Confidential&nbsp;</strong></span></td></tr><tr style='text-align:center;'><td colspan='2' style='border: 1px solid black; border-top: 0;'><span><strong>&nbsp;Associate Information</strong></span></td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td width='25%' style='border: 1px solid black; border-top: 0; border-top: 0;'><span>&nbsp;Name</span></td><td width='35%' style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;5</td><td width='15%' style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;Location</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Location:</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;ID</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Employee ID</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;PAN</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;PAN</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Designation</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Designation</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;Bank A/C</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Bank A/C</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Gender</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Gender</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;IFSC Code</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;IFSC Code</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Date of Joining</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;NaN/NaN/NaN</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;PF A/C</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;PF A/C</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Date of Birth</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;NaN/NaN/NaN</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;Status</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0;'>&nbsp;Status</td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td width='40%' style='border: 1px solid black; border-top: 0; border-right: 0;'><span>&nbsp;Available Calendar Days:</span>&nbsp;Available Calendar Days</td><td width='30%' style='border: 1px solid black; border-top: 0; border-right: 0; border-left: 0;'><span>&nbsp;Loss of Pay Days:</span>&nbsp;Loss of Pay Days</td><td style='border: 1px solid black; border-top: 0; border-left: 0;'><span>&nbsp;Paid Days:</span>&nbsp;Paid Days</td></tr><tr><td colspan='3' style='border: 0px solid black;'>&nbsp;</td></tr><tr><td colspan='3' style='border: 1px solid black; text-align:center;'><span><strong>&nbsp;Earnings</strong></span></td></tr><tr><td colspan='3' style='border: 1px solid black; border-top: 0;'><span><strong>&nbsp;Regular Earnings</strong></span></td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td width='75%' style='border: 1px solid black; border-top: 0;'><span>&nbsp;Basic</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Basic&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Conveyance Allowance</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Conveyance Allowance&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;House Rent Allowance</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>House Rent Allowance&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Special Allowance</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Special Allowance&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Medical Allowance</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Medical allowance&nbsp;</td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td width='50%' style='border: 1px solid black; border-top: 0; text-align:center;'><span><strong>&nbsp;Gross Pay</strong> (A)</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>(A) Total Earnings&nbsp;</td></tr><tr><td colspan='2' style='border: 0px solid black;'>&nbsp;</td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td colspan='2' style='border: 1px solid black; text-align:center;'><span><strong>&nbsp;Deductions</strong></span></td></tr><tr><td colspan='2' style='border: 1px solid black; border-top: 0;'><span><strong>&nbsp;Regular Deductions</strong></span></td></tr><tr><td width='75%' style='border: 1px solid black; border-top: 0;'><span>&nbsp;Provident Fund</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Provident Fund&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;TDS</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>IncomeTax (TDS)&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span>&nbsp;Professional Tax</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>Professional Tax&nbsp;</td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td width='50%' style='border: 1px solid black; border-top: 0; text-align:center;'><span><strong>&nbsp;Gross Deductions</strong> (B)</span></td><td style='border: 1px solid black; border-top: 0; border-left: 0; text-align:right;'>(B) Total Deductions&nbsp;</td></tr><tr><td colspan='2' style='border: 0px solid black;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; text-align:center;'><span><strong>&nbsp;Net Pay</strong> (A)-(B)</span></td><td style='border: 1px solid black; border-left: 0; text-align:right;'>Net Salary= (A) -(B)&nbsp;</td></tr><tr><td colspan='2' style='border: 0px solid black;'>&nbsp;</td></tr><tr><td style='border: 1px solid black;' colspan='2'><span><small>&nbsp;This computer generated Payslip is not valid unless authorized</small></span></td></tr></table><table cellspacing='0' cellpadding='0' width='100%'><tr><td style='border: 1px solid black; border-top: 0; border-bottom: 0;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0; border-bottom: 0;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0; border-bottom: 0;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0; border-bottom: 0;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0; border-bottom: 0;'>&nbsp;</td></tr><tr><td style='border: 1px solid black; border-top: 0;'><span><br><br><br><br><strong>&nbsp;Authorization</strong></span></td></tr><tr style='text-align:center;'><td style='border: 1px solid black; border-top: 0;' colspan='4'><span>&nbsp;Registered Office:<br/> Aurum Info Solution<br/> 248, 3rd Link Street, IT Express Way, Kottivakkam, Chennai 600096.</span></td></tr></table></body></html>";
		    FileOutputStream file = new FileOutputStream(new File("Test.pdf"));
		    Document document = new Document();
		    PdfWriter.getInstance(document, file);
		    document.open();
		    HTMLWorker htmlWorker = new HTMLWorker(document);
		    htmlWorker.parse(new StringReader(k));
		    document.close();
		    file.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		

    	PDDocument doc = null;
    	
		try {
			doc = PDDocument.load("Test.pdf");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	int keyLength = 128;

    	AccessPermission ap = new AccessPermission();

    	// disable printing, everything else is allowed
    	ap.setCanPrint(false);
    	

    	// owner password (to open the file with all permissions) is "12345"
    	// user password (to open the file but with restricted permissions, is empty here) 
    	StandardProtectionPolicy spp = new StandardProtectionPolicy("12345", "12345678", ap);
    	spp.setEncryptionKeyLength(keyLength);
    	spp.setPermissions(ap);
    	try {
			doc.protect(spp);
		} catch (BadSecurityHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	try {
			doc.save("filename-encrypted.pdf");
		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			doc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ok(new File("filename-encrypted.pdf"));

	}
}
