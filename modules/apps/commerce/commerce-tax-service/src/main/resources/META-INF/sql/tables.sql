create table CommerceTaxCategoryMapping (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	commerceTaxCategoryMappingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	commerceTaxMethodId LONG,
	CPTaxCategoryId LONG
);

create table CommerceTaxMethod (
	mvccVersion LONG default 0 not null,
	commerceTaxMethodId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	active_ BOOLEAN,
	description STRING null,
	engineKey VARCHAR(75) null,
	name STRING null,
	percentage BOOLEAN,
	typeSettings TEXT null
);