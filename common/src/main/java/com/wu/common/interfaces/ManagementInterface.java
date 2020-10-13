package com.wu.common.interfaces;

import java.util.List;

public interface ManagementInterface {

    /**
     * return the list of certain object
     * @return list
     **/
    List<?> queryAll();

    /**
     * look up certain object
     * @return one object
     * todo
     */
    Object query();

    /**
     * verification
     * sending to verification channel
     * todo
     */


}
