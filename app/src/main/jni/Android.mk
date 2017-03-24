LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := HelloNDK

LOCAL_SRC_FILES := HelloNDK.c

include $(BUILD_SHARED_LIBRARY)