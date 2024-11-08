package org.example.service;

import org.example.entity.EmailDetails;

import java.util.List;

public interface EmailDatabaseService {
    public EmailDetails addEmailInfoToDB(EmailDetails emailDetailsRecord);
    public void updateEmailDetailsStatus(EmailDetails updatedEmailDetailsRecord, Integer id);
    List<EmailDetails> getFailedEmails();
}
