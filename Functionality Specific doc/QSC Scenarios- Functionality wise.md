QSC Functionality wise scenarios
Below are the scenarios covered under listed functionalities:

######################################################Inbound SCENARIOS#####################################################################
1.	ASN Creation
•	Scenario 1: Creating ASN through EDI & checking status of the shipment

2.	Receiving & Putaway
•	Scenario 1: Receiving to Staging location & Putaway - Single Line, Single iLPN & Putaway
•	Scenario 2: Receiving to Staging location & Putaway - Single Line, Multiple iLPN & Putaway
•	Scenario 3: Receiving to Staging location & Putaway - Multi Line, Multiple iLPN & putaway

3.	Receiving bypass Staging (case)
•	Scenario 1: Receive and bypass stage or holding location (Case)

4.	Blind Receipt & Putaway
•	Scenario 1: Over Receiving of products using blind receipt - OV & Putaway
•	Scenario 2: Receiving of Damaged Return products using blind receipt - DM & Putaway
•	Scenario 3: Receiving of Returned Un-Delivered Product using blind receipt - UD & Putaway

5.	SPLIT ILPN
•	Scenario 1: Move few quantities from 1st iLPN to 2nd iLPN & validating LPN's in Inventory by location

6.	Damaged Receive & Putaway
•	Scenario 1: Receive Damages- Receiving Damaged Product using MM3 Recv-Damages 

7.	VALIDATE LOCKS-LOCK/UNLOCK
•	Scenario 1: Lock an iLPN using the user provided lock code
•	Scenario 2: Unlock an iLPN which already has some lock

8.	INVENTORY ADJUSTMENTS
•	Scenario 1: Increase iLPN qty having no lock code
•	Scenario 2: Decrease iLPN qty having no lock code
•	Scenario 3: Increase iLPN qty having unallocatable lock code
•	Scenario 4: Decrease iLPN qty having unallocatable lock code
•	Scenario 5: Delete line from an iLPN having no lock code
•	Scenario 6: Delete line from an iLPN having unallocatable lock coden

9.	CONSUME ILPN
•	Scenario 1: Consume iLPN having no lock
•	Scenario 2: Consume iLPN having lock code

10.	Kelli Scenarios
•	Scenario 1: Kelli ASN Load- Single Line
•	Scenario 2: Kelli ASN Load- Multi Line
•	Scenario 3: Receiving Single line ASN uploaded from Kelli
•	Scenario 4: Receiving Multi line ASN uploaded from Kelli
•	Scenario 5: Kelli Item Load
•	Scenario 6: Kelli Location Load

11.	RF Inquiry Transactions
•	Scenario 1: MM3 ASN Inquiry
•	Scenario 2: MM3 Item Inquiry
•	Scenario 3: MM3 Location Inquiry
•	Scenario 4: MM3 iLPN Inquiry
•	Scenario 5: MM3 oLPN Inquiry

12.	Auto Close ASN
•	Scenario 1: Auto Close ASN- Receving qty matches Shipped qty -single Line
•	Scenario 2: Auto Close ASN- Receving qty matches Shipped qty -Multi Line
•	Scenario 3: Received qty is less than ASN qty – Single Line.


13.	Partial Receiving (Mplus Partially verified status)(Receiving across multiple days)
•	Scenario 1: Receiving Partial Qty from an ASN- Single Line
•	Scenario 2: Receiving Partial Qty from both the lines of an ASN- Multi Line
•	Scenario 3: Receiving 1st line with all quantities and 2nd line with partial quantities of an ASN
•	Scenario 4: Receiving Partial Qty from both the lines of an ASN- Multi Line having same items 
•	Scenario 5: Receiving 1st line with all quantities and 2nd line with partial quantities of an ASN- Multi Line with same items




14.	Putaway HevayWeight/OverSized/Normal Items
•	Scenario 1: Receving ASN & completing HeavyWeight Items Putaway
•	Scenario 2: Receving ASN & completing Oversized Putaway
•	Scenario 3: Receving ASN & completing NormalPutaway

#####################################################OUTBOUND SCENARIOS#####################################################################

15.	Shipping Scenarios
•	Scenario 1: Distribution Order creation via EDI
•	Scenario 2: Distribution Order Shipping - Single Line - LTL
•	Scenario 3: Distribution Order Shipping - Multi Line - LTL
•	Scenario 4: Distribution Order Shipping - Single Line - Parcel
•	Scenario 5: Distribution Order Shipping - Multi Line - Parcel
•	Scenario 6: Distribution Order Shipping - Single Line Shortage
•	Scenario 7: Fill/Kill

16.	RF Pack Case from Transitional
•	Scenario 1: MM3 RF Pack Case from Transitional


17.	Modify/Adjust OLPN 
•	Scenario 1: Modify/Adjust Single Line oLPN in Printed status, Alter/Adjust the Units of the OLPN greater then the Current units 
•	Scenario 2: Modify/Adjust Single Line oLPN in Weighed status, Alter/Adjust the Units of the OLPN lesser then the Current units
•	Scenario 3: Modify/Adjust Single Line oLPN in Weighed status, Alter/Adjust the Units of the OLPN greater then the Current units


18.	SPLIT MOVE oLPN
•	Scenario 1: MM3 SPLIT/MOVE oLPN - Spliting the OLPN at Printed status 
•	Scenario 2: MM3 SPLIT/MOVE oLPN - Spliting the OLPN at Weighed status

19.	SPLIT COMBINE oLPN 
•	Scenario 1: MM3 SPLIT COMBINE oLPN - Combining OLPN at Printed status 
•	Scenario 2: MM3 SPLIT COMBINE oLPN - Combining OLPN at Weighed status 

20.	Cancel oLPN
•	Scenario 1: Single Line - Cancel the OLPN at Printed status
•	Scenario 2: Single Line - Cancel the OLPN at Weighed  status
•	Scenario 3: Single Line - Cancel the OLPN at Shipped  status
•	Scenario 4: Multi Line - Cancel the OLPN at Printed status
•	Scenario 5: Multi Line - Cancel the OLPN at Weighed status







	
	 
	
	
