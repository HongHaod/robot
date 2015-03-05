/*
 * =====================================================================
 * Copyright (c) NAB 2015
 * =====================================================================
 * (C) 2015 National Australia Bank Ltd [All rights reserved]. This
 * product and related documentation are protected by copyright
 * restricting its use, copying, distribution, and decompilation. No
 * part of this product or related documentation may be reproduced in
 * any form by any means without prior written authorization of
 * National Australia Bank Ltd. No part of this product can be sold,
 * leased, hired out, licensed or circulated in any way without the
 * written authorization of National Australia Bank Ltd. Unless
 * otherwise arranged, third parties may not have access to this
 * product or related documents.
 * =====================================================================
 */
package robot;

public class RobotAlreadyExistException extends RuntimeException {
    
    private static final long serialVersionUID = -7601055175674926671L;
    
    public RobotAlreadyExistException() {
        super();
    }
    public RobotAlreadyExistException(final String message) {
        super(message);
    }
}
