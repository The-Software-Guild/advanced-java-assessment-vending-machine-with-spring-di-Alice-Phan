package com.mattu.vendingmachine.service;

import com.sal.vendingmachine.dao.AuditDao;
import com.sal.vendingmachine.dao.VendingMachineException;

public class VendingMachineAuditDaoStubImpl implements AuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachineException {
        // do nothing...
    }
}


