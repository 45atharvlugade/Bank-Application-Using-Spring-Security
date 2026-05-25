package com.al.entity;

public enum AuditAction {

    //  Authentication & Security
    LOGIN_SUCCESS,
    LOGIN_FAILED,
    LOGOUT,
    SESSION_EXPIRED,

    PASSWORD_CHANGED,
    PASSWORD_RESET_REQUESTED,

    ACCOUNT_LOCKED,
    ACCOUNT_UNLOCKED,

    //  User Management (High importance audit events)
    USER_CREATED,
    USER_UPDATED,
    USER_DELETED,

    ROLE_ASSIGNED,
    ROLE_REMOVED,

    PERMISSION_GRANTED,
    PERMISSION_REVOKED,

    //  Data / CRUD Auditing (core audit purpose)
    DATA_CREATED,
    DATA_UPDATED,
    DATA_DELETED,
    DATA_VIEWED,

    //  Sensitive Access Tracking
    SENSITIVE_DATA_ACCESSED,
    REPORT_DOWNLOADED,
    FILE_UPLOADED,
    FILE_DELETED,

    //  Security Violations
    UNAUTHORIZED_ACCESS_ATTEMPT,
    ACCESS_DENIED,
    SUSPICIOUS_ACTIVITY,
    MULTIPLE_FAILED_LOGINS,

    // Admin / System Critical Actions
    CONFIG_CHANGED,
    SYSTEM_SETTING_UPDATED,
    BACKUP_CREATED,
    RESTORE_PERFORMED
}