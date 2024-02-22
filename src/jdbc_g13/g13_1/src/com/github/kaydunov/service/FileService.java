package com.github.kaydunov.service;

import java.util.List;

public interface FileService extends Service
{
    /**
     * Find files in the database by using the specified mask with full path.
     */
    List<String> findFilesByMask(String mask);
}
