package ca.gc.agr.mbb.hostpathogen.web.service.impl;

import ca.gc.agr.mbb.hostpathogen.web.model.User;


public interface PasswordTokenManager {

    /**
     * {@inheritDoc}
     */
    String generateRecoveryToken(User user);

    /**
     * {@inheritDoc}
     */
    boolean isRecoveryTokenValid(User user, String token);

    void invalidateRecoveryToken(User user, String token);
}