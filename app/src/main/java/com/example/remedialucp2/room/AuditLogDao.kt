package com.example.remedialucp2.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AuditLogDao {

    @Insert
    suspend fun insert(log: AuditLog)
}
