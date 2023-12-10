package com.cativointing.userdata.food;

public enum Status {
    REQUESTED {
        @Override
        public String toString() {
            return "Awaiting Approval";
        }
    },
    PENDING {
        @Override
        public String toString() {
            return "In Progress";
        }
    },
    DONE {
        @Override
        public String toString() {
            return "Ready";
        }
    },
}