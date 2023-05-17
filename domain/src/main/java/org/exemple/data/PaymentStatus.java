package org.exemple.data;

public enum PaymentStatus {
    waiting_transfer,
    select_transfers,
    waiting_notification,
    failed_notification,
    completed,
    rejected,
    expired,
    cancelled,
    anulled,
    waiting_connection
}
