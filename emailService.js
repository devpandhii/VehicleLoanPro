// emailService.js
const nodemailer = require('nodemailer');
require('dotenv').config();

class EmailService {
    constructor() {
        // CORRECT
this.transporter = nodemailer.createTransport({

            service: 'gmail',
            auth: {
                user: process.env.EMAIL_USER,
                pass: process.env.EMAIL_PASSWORD
            }
        });
    }

    async sendWelcomeEmail(toEmail, customerName) {
        const mailOptions = {
            from: process.env.EMAIL_USER,
            to: toEmail,
            subject: 'Welcome to VehicleLoan Pro!',
            html: this.createWelcomeEmailTemplate(customerName)
        };

        try {
            const info = await this.transporter.sendMail(mailOptions);
            console.log('Email sent successfully:', info.messageId);
            return { success: true, messageId: info.messageId };
        } catch (error) {
            console.error('Email sending failed:', error);
            return { success: false, error: error.message };
        }
    }

    createWelcomeEmailTemplate(customerName) {
        return `
            <html>
            <body style="font-family: Arial, sans-serif; line-height: 1.6; color: #333;">
                <div style="max-width: 600px; margin: 0 auto; padding: 20px;">
                    <div style="background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 30px; border-radius: 15px; text-align: center; margin-bottom: 30px;">
                        <h1 style="color: white; margin: 0;">🚗 VehicleLoan Pro</h1>
                        <p style="color: white; margin: 10px 0 0 0;">Your trusted vehicle financing partner</p>
                    </div>
                    
                    <h2 style="color: #667eea;">Welcome aboard, ${customerName}! 🎉</h2>
                    <p>Thank you for choosing VehicleLoan Pro. Your account has been successfully created and you're now part of our growing family of satisfied customers.</p>
                    
                    <div style="background: #f8f9ff; padding: 25px; border-radius: 15px; margin: 25px 0; border-left: 5px solid #667eea;">
                        <h3 style="color: #667eea; margin-top: 0;">🎯 What's Next?</h3>
                        <ul style="margin: 0; padding-left: 20px;">
                            <li style="margin-bottom: 8px;">✅ Complete your loan application</li>
                            <li style="margin-bottom: 8px;">📄 Upload required documents</li>
                            <li style="margin-bottom: 8px;">⚡ Get instant pre-approval</li>
                            <li style="margin-bottom: 8px;">🚗 Choose your dream vehicle</li>
                        </ul>
                    </div>
                    
                    <div style="background: linear-gradient(135deg, #28a745, #20c997); padding: 20px; border-radius: 15px; text-align: center; margin: 25px 0;">
                        <p style="color: white; margin: 0; font-weight: 600;">🌟 Special Offer: Get 0.5% off on your interest rate for early applications!</p>
                    </div>
                    
                    <p>Need help? Our support team is available 24/7 to assist you with your loan application process.</p>
                    
                    <div style="text-align: center; margin-top: 30px; padding-top: 20px; border-top: 2px solid #f0f0f0;">
                        <p style="margin: 0; color: #666;">Best regards,<br><strong style="color: #667eea;">VehicleLoan Pro Team</strong></p>
                    </div>
                </div>
            </body>
            </html>
        `;
    }
}

module.exports = EmailService;