/*
 * Copyright (c) 2017 Nike, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nike.cerberus.command.core;

import com.beust.jcommander.Parameters;
import com.beust.jcommander.ParametersDelegate;
import com.nike.cerberus.command.Command;
import com.nike.cerberus.operation.Operation;
import com.nike.cerberus.operation.core.GenerateCertificateFilesOperation;

import static com.nike.cerberus.command.core.GenerateCertificateFilesCommand.COMMAND_DESCRIPTION;
import static com.nike.cerberus.command.core.GenerateCertificateFilesCommand.COMMAND_NAME;

@Parameters(
        commandNames = COMMAND_NAME,
        commandDescription = COMMAND_DESCRIPTION
)
public class GenerateCertificateFilesCommand implements Command {

    public static final String COMMAND_NAME = "generate-certificate-files";
    public static final String COMMAND_DESCRIPTION = "Generates the TLS certificates needed to enable https " +
            "through out the system, using an ACME provider such as LetsEncrypt";

    @ParametersDelegate
    private GenerateCertificateFilesCommandParametersDelegate generateCertificateFilesCommandParametersDelegate =
            new GenerateCertificateFilesCommandParametersDelegate();

    public GenerateCertificateFilesCommandParametersDelegate getGenerateCertificateFilesCommandParametersDelegate() {
        return generateCertificateFilesCommandParametersDelegate;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public Class<? extends Operation<?>> getOperationClass() {
        return GenerateCertificateFilesOperation.class;
    }
}
