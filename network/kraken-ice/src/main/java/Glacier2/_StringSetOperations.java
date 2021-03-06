// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.4.1

package Glacier2;

// <auto-generated>
//
// Generated from file `Session.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>


/**
 * An object for managing the set of identity constraints for specific
 * parts of object identity on a
 * {@link Session}. 
 * 
 * @see Session
 * @see SessionControl
 * 
 **/
public interface _StringSetOperations
{
    /**
     * Add a sequence of strings to this set of constraints. Order is
     * not preserved and duplicates are implicitly removed.
     * 
     * @param additions The sequence of strings to be added.
     * 
     * @param __current The Current object for the invocation.
     **/
    void add(String[] additions, Ice.Current __current);

    /**
     * Remove a sequence of strings from this set of constraints. No
     * errors are returned if an entry is not found.
     * 
     * @param deletions The sequence of strings to be removed.
     * 
     * @param __current The Current object for the invocation.
     **/
    void remove(String[] deletions, Ice.Current __current);

    /**
     * Returns a sequence of strings describing the constraints in this
     * set.
     * 
     * @param __current The Current object for the invocation.
     * @return The sequence of strings for this set. 
     * 
     **/
    String[] get(Ice.Current __current);
}
