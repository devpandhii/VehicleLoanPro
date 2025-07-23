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

// Health check endpoint
app.get('/health', (req, res) => {
    res.json({ status: 'Email service is running' });
});

const PORT = process.env.EMAIL_SERVICE_PORT || 3001;
app.listen(PORT, () => {
    console.log(`Email service running on port ${PORT}`);
});