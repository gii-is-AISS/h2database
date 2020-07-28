/*
 * Copyright 2004-2020 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (https://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.command.dml;

import org.h2.command.Prepared;
import org.h2.engine.SessionLocal;
import org.h2.result.ResultTarget;
import org.h2.table.DataChangeDeltaTable.ResultOption;
import org.h2.table.Table;

/**
 * Data change statement.
 */
public abstract class DataChangeStatement extends Prepared {

    /**
     * Creates new instance of DataChangeStatement.
     *
     * @param session
     *            the session
     */
    protected DataChangeStatement(SessionLocal session) {
        super(session);
    }

    /**
     * Return the name of this statement.
     *
     * @return the short name of this statement.
     */
    public abstract String getStatementName();

    /**
     * Return the target table.
     *
     * @return the target table
     */
    public abstract Table getTable();

    @Override
    public final int update() {
        return update(null, null);
    }

    /**
     * Execute the statement with specified delta change collector and collection mode.
     *
     * @param deltaChangeCollector
     *            target result
     * @param deltaChangeCollectionMode
     *            collection mode
     * @return the update count
     */
    public abstract int update(ResultTarget deltaChangeCollector, ResultOption deltaChangeCollectionMode);

}
