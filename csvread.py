

import pandas as pd
from sql import create_engine
from sql.orm import sessionmaker
from sql.ext.declarative import declarative_base
from sqlimport Table,Column,Integer,String
import glob
import os
from sqlimport MetaData
from sql.orm import mapper


engine=create_engine('sqlite:///product_dbase.sqlite',echo=False)

Session=sessionmaker(bind=engine)
session=Session()


Base=declarative_base()


metadata=MetaData(engine)


class product_table(object):
    def __init__(self,number,description,ref_des):
        self.product_id=product_id
        self.station=station
        self.time=time
        self.result=result
        self.employee_id=employee_id
    
    def __repr__(self):
        return f'{self.product_id,self.station,self.time,self.result,self.employee_id}'

    

def table_definition(table_name):
    
    table_definition.table_define=Table(table_name,metadata,
    Column('Result Time',Integer,primary_key=True),
    Column('Granularity Period',String),
    Column('Object Name',String),
    Column('Object id',String),
    Column('callattempts',String),
    
    )
    
   
    metadata.create_all(engine)
    
    
    mapper(product_table,table_definition.table_define,non_primary=True)

    


table_define_dummy=Table('dummy_table',metadata,
Column('Result Time',Integer,primary_key=True),
Column('granularity period',String),
Column('obect name',String),
Column('object id',String),
Column('call callattempts',String),

)


metadata.create_all(engine)


mapper(product_table,table_define_dummy)


def create_table(folder_of_files):
    
    
    files=glob.glob(os.path.join(folder_of_files,"*.csv"))
    
    
    
    for file_name in files:
        
        
        csv_data=pd.read_csv(file_name)
        
        
        csv_data=csv_data.values.tolist()
        
        
        table_name_from_file=file_name.split('/')[8][:-4]
        
        
        table_definition(table_name_from_file)
        
        
        for row in csv_data:
            
            
            ins=table_definition.table_define.insert().values(
            product_id=result time[0],granularity period=row[1],object_name=row[2],call_id=row[3],call_attempts=row[4])
            conn=engine.connect()
            conn.execute(ins)
            


create_table("path of folder where csv files are stored")