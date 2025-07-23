// emailServer.js
const express = require('express');
const cors = require('cors');
const EmailService = require('./emailService');

const app = express();
const emailService = new EmailService();

// Middleware
app.use(cors());
app.use(express.json());

// Email endpoint
app.post('/send-welcome-email', async (req, res) => {
    try {
        const { email, name } = req.body;
        
        if (!email || !name) {
            return res.status(400).json({
                success: false,
                message: 'Email and name are required'
            });
        }

        const result = await emailService.sendWelcomeEmail(email, name);
        
        if (result.success) {
            res.status(200).json({
                success: true,
                message: 'Welcome email sent successfully',
                messageId: result.messageId
            });
        } else {
            res.status(500).json({
                success: false,
                message: 'Failed to send email',
                error: result.error
            });
        }
    } catch (error) {
        console.error('Email API error:', error);
        res.status(500).json({
            success: false,
            message: 'Internal server error'
        });
    }
});

app.post('/send-otp-email', async (req, res) => {
    try {
        const { email, name, otp } = req.body;

        if (!email || !name || !otp) {
            return res.status(400).json({
                success: false,
                message: 'Email, name, and OTP are required'
            });
        }

        const result = await emailService.sendOtpEmail(email, name, otp);

        if (result.success) {
            res.status(200).json({
                success: true,
                message: 'OTP email sent successfully',
                messageId: result.messageId
            });
        } else {
            res.status(500).json({
                success: false,
                message: 'Failed to send OTP email',
                error: result.error
            });
        }
    } catch (error) {
        console.error('OTP Email API error:', error);
        res.status(500).json({
            success: false,
            message: 'Internal server error'
        });
    }
});

const multer = require('multer');
const upload = multer(); // use memory storage for PDF

app.post('/send-statement-email', upload.single('pdf'), async (req, res) => {
  const { email, name } = req.body;
  const { buffer } = req.file;

  if (!email || !name || !buffer) {
    return res.status(400).json({ success: false, message: 'Missing required fields.' });
  }

  const mailOptions = {
    from: process.env.EMAIL_USER,
    to: email,
    subject: 'Your Loan Statement - VehicleLoan Pro',
    html: `<p>Hello ${name},</p><p>Your requested loan statement is attached as a PDF.</p><p>Best,<br>VehicleLoan Pro</p>`,
    attachments: [
      {
        filename: 'Loan_Statement.pdf',
        content: buffer
      }
    ]
  };

  try {
    const info = await emailService.transporter.sendMail(mailOptions);
    res.json({ success: true, messageId: info.messageId });
  } catch (err) {
    console.error(err);
    res.status(500).json({ success: false, error: err.message });
  }
});



// Health check endpoint
app.get('/health', (req, res) => {
    res.json({ status: 'Email service is running' });
});

const PORT = process.env.EMAIL_SERVICE_PORT || 3001;
app.listen(PORT, () => {
    console.log(`Email service running on port ${PORT}`);
});