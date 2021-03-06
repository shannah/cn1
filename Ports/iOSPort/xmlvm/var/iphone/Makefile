PRODUCT_NAME=__PROJNAME__

ifeq (a, a$(IPHONE_SDK_HOME))
    IPHONE_SDK_HOME=/Developer/Platforms/iPhoneSimulator.platform/Developer/SDKs/iPhoneSimulator3.1.sdk
endif


ALL_SOURCES=$(wildcard $(SRCROOT)/lib/iphone/*.m) $(wildcard $(SRCROOT)/lib/android/*.m) $(wildcard $(SRCROOT)/app/*.m)


DEPLOY_DIR=$(HOME)/Library/Application\ Support/iPhone\ Simulator/User/Applications
DEPLOY_UUID=$(PRODUCT_NAME)
 

SRCROOT=src/xmlvm
RESOURCES=resources

BUILT_PRODUCTS_DIR=build

CONFIGURATION_TEMP_DIR=$(BUILT_PRODUCTS_DIR)/obj

INFOPLIST_FILE=$(PRODUCT_NAME)-Info.plist

CC=gcc-4.2

CFLAGS=-x objective-c -arch i386 -fmessage-length=0 -pipe -std=c99 \
       -Wno-trigraphs -fpascal-strings -fasm-blocks -O0 -Wreturn-type \
       -D__IPHONE_OS_VERSION_MIN_REQUIRED=30000 \
       -isysroot $(IPHONE_SDK_HOME) \
       -fvisibility=hidden -mmacosx-version-min=10.5 -gdwarf-2 \
       -I$(SRCROOT)/lib/iphone -I$(SRCROOT)/lib/android -I$(SRCROOT)/app


LD=$(CC)

LDFLAGS=-arch i386 \
        -isysroot $(IPHONE_SDK_HOME) \
        -mmacosx-version-min=10.5 \
        -framework Foundation -framework UIKit -framework CoreGraphics -framework QuartzCore \
        -framework AVFoundation -framework OpenGLES


WRAPPER_NAME=$(PRODUCT_NAME).app

EXECUTABLE_NAME=$(PRODUCT_NAME)

SOURCES_ABS=$(addprefix ./,$(ALL_SOURCES))

INFOPLIST_ABS=$(addprefix ./resources/sys/,$(INFOPLIST_FILE))

OBJECTS=\
	$(patsubst $(SRCROOT)/%.c,%.o,$(filter %.c,$(ALL_SOURCES))) \
	$(patsubst $(SRCROOT)/%.cc,%.o,$(filter %.cc,$(ALL_SOURCES))) \
	$(patsubst $(SRCROOT)/%.cpp,%.o,$(filter %.cpp,$(ALL_SOURCES))) \
	$(patsubst $(SRCROOT)/%.m,%.o,$(filter %.m,$(ALL_SOURCES))) \
	$(patsubst $(SRCROOT)/%.mm,%.o,$(filter %.mm,$(ALL_SOURCES)))

OBJECTS_ABS=$(addprefix $(CONFIGURATION_TEMP_DIR)/,$(OBJECTS))

APP_ABS=$(BUILT_PRODUCTS_DIR)/$(WRAPPER_NAME)

PRODUCT_ABS=$(APP_ABS)/$(EXECUTABLE_NAME)



all: compile deploy run

compile: $(PRODUCT_ABS)

$(PRODUCT_ABS): $(APP_ABS) $(OBJECTS_ABS)
	$(LD) $(LDFLAGS) -o $(PRODUCT_ABS) $(OBJECTS_ABS)

$(APP_ABS): $(INFOPLIST_ABS)
	mkdir -p $(APP_ABS)
	cp $(INFOPLIST_ABS) $(APP_ABS)/Info.plist
	if [ -d $(RESOURCES) ]; then find $(RESOURCES) -name "*" -type f -exec cp {} $(APP_ABS)/ \; ; fi

$(CONFIGURATION_TEMP_DIR)/%.o: $(SRCROOT)/%.m
	mkdir -p $(dir $@)
	$(CC) $(CFLAGS) $(CPPFLAGS) -c $< -o $@

deploy: compile
	mkdir -p $(DEPLOY_DIR)/$(DEPLOY_UUID)
	cd build; cp -R $(WRAPPER_NAME) $(DEPLOY_DIR)/$(DEPLOY_UUID)
	echo "(version 1)" > $(DEPLOY_DIR)/$(DEPLOY_UUID).sb
	echo "(debug deny)" >> $(DEPLOY_DIR)/$(DEPLOY_UUID).sb
	echo "(allow default)" >> $(DEPLOY_DIR)/$(DEPLOY_UUID).sb

run: deploy
	open /Developer/Platforms/iPhoneSimulator.platform/Developer/Applications/iPhone\ Simulator.app

clean:
	rm -rf $(CONFIGURATION_TEMP_DIR)
	rm -rf $(BUILT_PRODUCTS_DIR)
	rm -rf $(DEPLOY_DIR)/$(DEPLOY_UUID)
	rm -f $(DEPLOY_DIR)/$(DEPLOY_UUID).sb
	rm -f *~
